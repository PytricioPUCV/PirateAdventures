package io.github.some_example_name;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * La clase Pirate representa el personaje principal controlado por el jugador en el juego.
 * El pirata puede moverse, recolectar objetos, perder vidas, y tiene una animación básica para
 * diferentes direcciones de movimiento. Además, implementa las interfaces {@link Dibujable} y {@link Destruible}.
 */
public class Pirate implements Destruible, Dibujable {

    private Rectangle bucket;
    private Texture bucketImage;
    private TextureRegion[][] pirateRegions; // Matriz de sprites del pirata
    private Sound sonidoHerido;

    private int vidas = 3; // Vidas iniciales del pirata
    private int puntos; // Puntos acumulados
    private int velx = 280; // Velocidad inicial en el eje X
    private boolean herido = false; // Estado de herido
    private final int tiempoHeridoMax = 50; // Tiempo máximo en estado herido
    private int tiempoHerido; // Contador de tiempo herido
    private int direccion; // Dirección del pirata (0 = frontal, 1 = lateral, 2 = trasera)
    private int frameActual = 0; // Frame actual de la animación
    private boolean flipX = false; // Indica si el sprite debe voltearse horizontalmente
    private static final float MARGEN_SUPERIOR = 125f; // Margen superior en el límite del movimiento

    /**
     * Constructor de la clase Pirate.
     *
     * @param tex La textura que representa el sprite del pirata.
     * @param ss  El sonido que se reproduce cuando el pirata recibe daño.
     */
    public Pirate(Texture tex, Sound ss) {
        bucketImage = tex;
        sonidoHerido = ss;

        // Dividir la textura en una matriz de regiones de 32x32 para la animación
        pirateRegions = TextureRegion.split(bucketImage, 32, 32);
    }

    /**
     * Inicializa el área de colisión del pirata y lo posiciona en su ubicación inicial.
     */
    public void crear() {
        bucket = new Rectangle();
        bucket.width = 64;
        bucket.height = 64;
        bucket.x = (MyGame.WORLD_WIDTH - bucket.width) / 2;
        bucket.y = 20;
    }

    /**
     * Dibuja al pirata en la pantalla, aplicando un efecto de sacudida si está herido.
     *
     * @param batch El {@link SpriteBatch} utilizado para dibujar el pirata.
     */
    @Override
    public void dibujar(SpriteBatch batch) {
        if (frameActual >= pirateRegions.length || direccion >= pirateRegions[frameActual].length) {
            frameActual = 0;
            direccion = 0;
        }

        // Seleccionar el frame de animación y aplicarle flip horizontal si corresponde
        TextureRegion region = new TextureRegion(pirateRegions[frameActual][direccion]);
        if (flipX != region.isFlipX()) {
            region.flip(true, false);
        }

        if (!herido) {
            batch.draw(region, bucket.x, bucket.y, bucket.width, bucket.height);
        } else {
            batch.draw(region, bucket.x, bucket.y + MathUtils.random(-5, 5), bucket.width, bucket.height);
            tiempoHerido--;
            if (tiempoHerido <= 0) herido = false;
        }
    }

    /**
     * Actualiza el movimiento del pirata según las teclas presionadas. Si está herido,
     * el movimiento está deshabilitado hasta que termine el estado herido.
     */
    public void actualizarMovimiento() {
        if (herido) {
            tiempoHerido--;
            if (tiempoHerido <= 0) herido = false;
            return;
        }

        // Obtener la velocidad actualizada desde GameManager
        velx = (int) GameManager.getInstance().getPlayerSpeed();

        boolean moving = false;
        boolean up = Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W);
        boolean down = Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S);
        boolean left = Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A);
        boolean right = Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D);

        float deltaTime = Gdx.graphics.getDeltaTime();

        if (left && !right) {
            bucket.x -= velx * deltaTime;
            moving = true;
            flipX = true;
        } else if (right && !left) {
            bucket.x += velx * deltaTime;
            moving = true;
            flipX = false;
        }

        if (up && !down) {
            bucket.y += velx * deltaTime;
            moving = true;
        } else if (down && !up) {
            bucket.y -= velx * deltaTime;
            moving = true;
        }

        bucket.x = MathUtils.clamp(bucket.x, 0, MyGame.WORLD_WIDTH - bucket.width);
        bucket.y = MathUtils.clamp(bucket.y, 0, MyGame.WORLD_HEIGHT - bucket.height - MARGEN_SUPERIOR);

        if (moving) {
            direccion = left || right ? 1 : (down ? 0 : 2);
            frameActual = (frameActual + 1) % 4;
        } else {
            direccion = 2;
            frameActual = 0;
        }
    }

    /**
     * Aplica daño al pirata, reduciendo sus vidas y activando el estado herido.
     * Si las vidas llegan a 0, no se puede aplicar más daño.
     */
    public void dañar() {
        if (vidas > 0) {
            vidas--;
            herido = true;
            tiempoHerido = tiempoHeridoMax;
            sonidoHerido.play();
        }
        if (vidas <= 0) vidas = 0;
    }

    /**
     * Libera los recursos utilizados por el pirata, como la textura del sprite.
     */
    @Override
    public void destruir() {
        bucketImage.dispose();
    }

    /**
     * Verifica si el pirata está en estado herido.
     *
     * @return {@code true} si el pirata está herido, {@code false} en caso contrario.
     */
    public boolean estaHerido() {
        return herido;
    }

    /**
     * Reinicia el estado del pirata a sus valores iniciales, incluyendo vidas y posición.
     */
    public void reiniciar() {
        vidas = 3;
        puntos = 0;
        bucket.x = (MyGame.WORLD_WIDTH - bucket.width) / 2;
        bucket.y = 20;
    }

    /**
     * Obtiene el número de vidas restantes del pirata.
     *
     * @return El número de vidas actuales.
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * Obtiene el área de colisión del pirata.
     *
     * @return Un objeto {@link Rectangle} que representa el área de colisión del pirata.
     */
    public Rectangle getArea() {
        return bucket;
    }

    /**
     * Suma puntos al marcador del pirata.
     *
     * @param pp La cantidad de puntos a sumar.
     */
    public void sumarPuntos(int pp) {
        GameManager.getInstance().addScore(pp);
    }

    /**
     * Añade vidas al pirata.
     *
     * @param lives El número de vidas a añadir.
     */
    public void addLives(int lives) {
        vidas += lives;
    }

    /**
     * Obtiene la cantidad de puntos acumulados por el pirata.
     *
     * @return La cantidad de puntos acumulados.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Establece la cantidad de puntos acumulados por el pirata.
     *
     * @param puntos La cantidad de puntos a establecer.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
