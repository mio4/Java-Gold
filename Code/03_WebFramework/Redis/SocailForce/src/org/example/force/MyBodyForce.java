package org.example.force;

import org.socialforce.geom.Force;
import org.socialforce.geom.impl.Force2D;
import org.socialforce.geom.impl.Vector2D;
import org.socialforce.model.Agent;
import org.socialforce.model.Blockable;
import org.socialforce.model.Model;
import org.socialforce.model.Moveable;
import org.socialforce.model.impl.TypeMatchRegulation;

/**
 * 在社会力模型中应用 Fij。
 *其中包括“body force”和“sliding force”。
 * 定义了BodyForce类，其实现了接口ForceRegulation 的方法
 * Created by Whatever on 2016/8/26.
 *
 */
public class MyBodyForce extends TypeMatchRegulation<Blockable, Agent> {
    public MyBodyForce(Class<Blockable> blockableClass, Class<Agent> agentClass, Model model) {
        super(blockableClass, agentClass, model);
    }

    @Override
    public Force getForce(Blockable source, Agent target) {
        double k1,k2,g,bodyForce,slidingForce,distance,argumentX;
        Vector2D t,n,tempVector;
        k1 = 1.2 * 100000;
        k2 = 2.4 * 100000;
        g = 0;
        double temp[] = new double[2];
        //tempVector = the velocity of agent named "source"
        if (source instanceof Moveable){
            tempVector = (Vector2D)((Moveable)source).getVelocity().clone();
        }
        else
            tempVector = new Vector2D(0,0);

        tempVector.sub(target.getVelocity()); //tempVector = the difference vector between two velocities
        n = (Vector2D) target.getShape().directionTo(source.getShape());    //n = direction from source to target
        n.get(temp);
        t = new Vector2D(-temp[1],temp[0]);   //n = vertical vector of the direction from source to target
        distance = (target.getShape().distanceTo(source.getShape())); //distance = distance from source to target
        if (distance < 0)
            g = 1;     //whether there exists body force and sliding force

        //TODO： fill in the blanks
        bodyForce = 10.0;
        slidingForce = 10.0;

        n.scale(bodyForce);
        t.scale(slidingForce);
        n.add(t);
        n.get(temp);
        return new Force2D(temp[0],temp[1]);
    }
}
