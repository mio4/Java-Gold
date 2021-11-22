//package org.example.force;
//
//import org.socialforce.geom.Force;
//import org.socialforce.model.Agent;
//import org.socialforce.model.Blockable;
//import org.socialforce.model.Model;
//import org.socialforce.model.impl.TypeMatchRegulation;
//
///**
// * 定义了PsychologicalForceRegulation类，其继承于父类TypeMatchRegulation
// * Created by Ledenel on 2016/8/19.
// */
//
//public class MyPsychologicalForceRegulation extends TypeMatchRegulation<Blockable, Agent> {
//    public static final double A = 2000;
//    public static final double B = 0.08;
//
//    /**
//     *TODO regulate 是翻译成调节还是控制，还是计算的意思？
//     *  计算两个agent之间的心理作用力。
//     * @param agentClass
//     * @param agentClass2
//     * @param model
//     */
//    public MyPsychologicalForceRegulation(Class<Blockable> agentClass, Class<Agent> agentClass2, Model model) {
//        super(agentClass, agentClass2, model);
//    }
//
//
//    /**
//     *获取源实体和目标实体之间的作用力。
//     * @param source
//     * @param target
//     * @return force
//     */
//    @Override
//    public Force getForce(Blockable source, Agent target) {
//        Force force = model.zeroForce();
//        force.add((target.getShape()).directionTo(source.getShape()));
//        force = force.getRefVector();    //direction of the force, a unit vector
//        double distance = target.getShape().distanceTo(source.getShape());   //distance between two entities
//        //TODO： fill in the blank
//        double scale = ______________________;
//        force.scale(scale);
//        return force;
//    }
//}
