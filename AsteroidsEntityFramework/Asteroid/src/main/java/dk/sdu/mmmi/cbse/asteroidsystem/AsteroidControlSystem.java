package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;


/**
 *
 * @author jcs
 */
public class AsteroidControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        /*
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);

            movingPart.setUp(true);

            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);

            setShape(asteroid, 12);
        }

         */

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            LifePart lifePart = asteroid.getPart(LifePart.class);

            int numPoints = 12;
            movingPart.setUp(true);

            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);

            /*
            if (lifePart.isHit()) {
                world.removeEntity(asteroid);
            }

             */
            setShape(asteroid, numPoints);
        }
    }

    private void setShape(Entity entity, int numPoints) {


        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 9 + 6);
        shapey[0] = (float) (y + Math.sin(radians) * 6  + 9);

        shapex[1] = (float) (x + Math.cos(radians - 2 * 3.1415f / 5) * 9);
        shapey[1] = (float) (y + Math.sin(radians - 5 * 3.1145f / 2) * 10);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 7);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 4);

        shapex[3] = (float) (x + Math.cos(radians + 3 * 3.1415f / 5) * 7);
        shapey[3] = (float) (y + Math.sin(radians + 6 * 3.1415f / 5) * 6);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);


    }

}
