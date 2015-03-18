package com.gcc2ge.game.groovy

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.graphics.Texture;
import com.gcc2ge.game.Transition;
import com.gcc2ge.game.Transition.TransitionCallBack;
import com.gcc2ge.game.ai.GridXY;
import com.gcc2ge.game.entity.Oriention;

//new File("F:/workspace/birdeye-android/assets/img/3").eachFile {
//	println """ ${it.getName()}= manager.get("img/3/${it.getName()}");"""
//}

//println Math.atan2(0, 1)/Math.PI//right 0
//println Math.atan2(1, 0)/Math.PI//up .5
//println Math.atan2(0, -1)/Math.PI//left 1
//println Math.atan2(-1, 0)/Math.PI//down -0.5

GridXY g=new GridXY(1,1);
GridXY g2=new GridXY(2,1);
print Oriention.getOriention(g.angleTo(g2))


//String s1=new String("zhaoxudong");
//String s2=new String("zhaoxudong");
//println s1.hashCode()
//println  s2.hashCode()


//Transition t=new Transition();
//t.start(0, 20, 1,new TransitionCallBack(){
//		public void onStart(int value){
//			println 'start '	+value
//		}
//		public void onProgress(int value){
//			println 'progress '	+value
//		}
//		public void onEnd(int value){
//			println 'end '	+value
//			t.reStart(30, 40)
//		}
//	}
//)
//ScheduledExecutorService  exector=Executors.newScheduledThreadPool(1)
//exector.scheduleAtFixedRate(new Runnable(){
//	public void run(){
//		t.step();
//	}
//}, 0, 1, TimeUnit.SECONDS)
