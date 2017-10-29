package com.chair49.astroids.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.chair49.astroids.controller.AsteroidFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jacob on 29/10/17.
 */
public class AsteroidField {
    public List<Asteroid> asteroids;
    World world;
    final int asteroidCount = 100;
    public final static float worldWidth = 16f;
    public final static float worldHeight = 9f;
    // Ratio between Gdx world measurements and coordinate system.
    public final static float boxToWorld = Gdx.graphics.getWidth() / worldWidth;

    public AsteroidField() {
        // Linked list because we will mainly be iterating the entire array as well as adding and removing from random indices
        asteroids = new LinkedList<Asteroid>();
        Box2D.init();
        world = new World(new Vector2(0, 0), true);


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
}

