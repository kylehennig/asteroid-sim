package com.chair49.asteroids.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jacob on 29/10/17.
 */
public class AsteroidField {
    public final static float worldWidth = 16f;
    public final static float worldHeight = 9f;
    // Ratio between Gdx world measurements and coordinate system.
    public final static float boxToWorld = Gdx.graphics.getWidth() / worldWidth;
    public List<Asteroid> asteroids;
    public List<LightWeightAsteroidThingy> asteroidsToAdd;
    public Shuttle shuttle;
    World world;
    int asteroidCount;
    HashMap<Body, Asteroid> bodyToAsteroid;

    public AsteroidField() {

    }

    public void addAsteroid(Asteroid a) {
        bodyToAsteroid.put(a.getBody(), a);
        asteroids.add(a);
    }

    public World getWorld() {
        return world;
    }

    public float getWorldWidth() {
        return worldWidth;
    }

    public float getWorldHeight() {
        return worldHeight;
    }

    public float getBoxToWorld() {
        return boxToWorld;
    }

    public int getAsteroidCount() {
        return asteroidCount;
    }

    public Asteroid getAsteroidFromBody(Body b2) {
        return bodyToAsteroid.get(b2);
    }

    public void setup(int asteroidCount) {
        this.asteroidCount = asteroidCount;
        // Linked list because we will mainly be iterating the entire array as well as adding and removing from random indices
        asteroids = new LinkedList<Asteroid>();
        asteroidsToAdd = new LinkedList<LightWeightAsteroidThingy>();
        Box2D.init();
        world = new World(new Vector2(0, 0), true);
        bodyToAsteroid = new HashMap<Body, Asteroid>();

        // Create the shuttle
        shuttle = new Shuttle(world);
    }
}

