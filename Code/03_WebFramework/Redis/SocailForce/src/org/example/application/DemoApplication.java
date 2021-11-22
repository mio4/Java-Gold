package org.example.application;

import org.example.model.SocialForceModel;
import org.socialforce.app.Applications.SimpleApplication;
import org.socialforce.geom.DistanceShape;
import org.socialforce.geom.impl.Box2D;
import org.socialforce.geom.impl.Circle2D;
import org.socialforce.geom.impl.Point2D;
import org.socialforce.geom.impl.Velocity2D;
import org.socialforce.model.impl.*;
import org.socialforce.scene.Scene;
import org.socialforce.scene.SceneLoader;
import org.socialforce.scene.impl.*;
import org.socialforce.strategy.GoalStrategy;
import org.socialforce.strategy.PathFinder;
import org.socialforce.strategy.impl.AStarPathFinder;
import org.socialforce.strategy.impl.FurthestGoalStrategy;

import java.util.Iterator;

/**
 * Created by sunjh1999 on 2017/2/26.
 */
public class DemoApplication extends SimpleApplication {
    DistanceShape template;
    public DemoApplication(){
    }
    /**
     * start the org.example.application immediately.
     */
    @Override
    public void start() {
        setUpScenes();
        for (Iterator<Scene> iterator = scenes.iterator(); iterator.hasNext();){
            currentScene = iterator.next();
            PathFinder pathFinder = new AStarPathFinder(currentScene, template);
            GoalStrategy strategy = new FurthestGoalStrategy(currentScene, pathFinder);
            strategy.pathDecision();
            while (!toSkip()) {
                this.StepNext(currentScene);
            }
            if(onStop()) return;
        }
    }

    /**
     * 需要根据parameter的map来生成一系列scene
     */
    @Override
    public void setUpScenes(){
        template = new Circle2D(new Point2D(0,0),0.486/2);
        SceneLoader loader = new StandardSceneLoader(new SimpleScene(new Box2D(-50, -50, 100, 100)),
                new Wall[]{
                        new Wall(new Box2D(20,-3,1,15))
                }).setModel(new SocialForceModel());

        SimpleParameterPool parameters = new SimpleParameterPool();

        parameters.addValuesAsParameter(new RandomEntityGenerator2D(30,new Box2D(3,1,3,8))
                .setValue(new BaseAgent(template, new Velocity2D(3,0)))
                                        ,new RandomEntityGenerator2D(1,new Box2D(3,1,5,8))
                .setValue(new BaseAgent(template, new Velocity2D(3,0)))
        );

        //parameters.addValuesAsParameter(new RandomEntityGenerator2D(1,new Box2D(33,1,3,8))
                //.setValue(new BaseAgent(template, new Velocity2D(-3,0)))
        //);

        parameters.addValuesAsParameter(new MultipleEntitiesGenerator()
                .addValue(new Exit(new Box2D(19,3,3,1)))
                .addValue(new SafetyRegion(new Box2D(46,1,1,8)))
                .addValue(new SafetyRegion(new Box2D(-6,1,1,8)))
        );

        loader.readParameterSet(parameters);
        scenes = loader.readScene();
        for(Scene scene:scenes){
            scene.setApplication(this);
        }
    }
}