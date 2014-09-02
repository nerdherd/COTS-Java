/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.camsrobotics.frc2013;


import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * Java Version of frc687 2013 robot code
 * @author tharder@lbschools.net
 * @version 20140902
 */
public class UltimateAscentRobot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    DoubleSolenoid Shifters, Lock, Shooter;
    Joystick       Joy1, Joy2;
    Compressor     compressor;
    CANJaguar      jag2, jag4, jag3, jag5, jag6, jag7;
    Victor         victor1, victor2;
    DigitalInput   digitalInput1, digitalInput2, digitalInput3, digitalInput4;
    
    public void robotInit() {
        Shifters = new DoubleSolenoid(1,2);
        Lock     = new DoubleSolenoid(7,8);
        Shooter  = new DoubleSolenoid(5,6);
        Joy1     = new Joystick(1);
        Joy2     = new Joystick(2);
        compressor = new Compressor(1,1);
        try{
            jag2 = new CANJaguar(2);
            jag4 = new CANJaguar(4);
            jag3 = new CANJaguar(3);
            jag5 = new CANJaguar(5);
            jag6 = new CANJaguar(6);
            jag7 = new CANJaguar(7);
        }catch(Exception e){
            System.out.println(e);
        }
        victor1 = new Victor(1);
        victor2 = new Victor(2);
        //digitalInput1 = new DigitalInput(1);
        digitalInput2 = new DigitalInput(2);
        digitalInput3 = new DigitalInput(3);
        digitalInput4 = new DigitalInput(4);
        
        
        compressor.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        boolean shifterForward = Joy1.getRawButton(1);
        boolean shifterBackward = Joy1.getRawButton(2);
        boolean LockForward = Joy1.getRawButton(3);
        boolean LockBackward = Joy1.getRawButton(4);
        boolean shooterForward = Joy1.getRawButton(5);
        boolean shooterBackward = Joy1.getRawButton(6);
        boolean victor1Forward = Joy1.getRawButton(7);
        boolean victor2Forward = Joy1.getRawButton(8);
        
        boolean jag2Forward  = Joy2.getRawButton(1);
        boolean jag4Forward  = Joy2.getRawButton(2);
        boolean jag3Forward  = Joy2.getRawButton(3);
        boolean jag5Forward  = Joy2.getRawButton(4);
        boolean jag6Forward  = Joy2.getRawButton(5);
        boolean jag7Forward  = Joy2.getRawButton(6);
        boolean compressorOn = Joy2.getRawButton(7);
        
        
        System.out.println(compressor.getPressureSwitchValue());
        
        if(shifterForward){
            Shifters.set(DoubleSolenoid.Value.kForward);
        }else if(shifterBackward){
            Shifters.set(DoubleSolenoid.Value.kReverse);
        }else{
            Shifters.set(DoubleSolenoid.Value.kOff);
        }
        
        if(LockForward){
            Lock.set(DoubleSolenoid.Value.kForward);
        }else if(LockBackward){
            Lock.set(DoubleSolenoid.Value.kReverse);
        }else{
            Lock.set(DoubleSolenoid.Value.kOff);
        }
        
        if(shooterForward){
            Shooter.set(DoubleSolenoid.Value.kForward);
        }else if(shooterBackward){
            Shooter.set(DoubleSolenoid.Value.kReverse);
        }else{
            Shooter.set(DoubleSolenoid.Value.kOff);
        }
        
        if(jag2Forward){
            jag2.set(0.75);
        }else{
            jag2.set(0.0);
        }
            
        if(jag4Forward){
            jag4.set(0.75);
        }else{
            jag4.set(0.0);
        }
        
        if(jag3Forward){
            jag3.set(1.0);
        }else{
            jag3.set(0.0);
        }
        
        if(jag5Forward){
            jag5.set(1.0);
        }else{
            jag5.set(0.0);
        }
        
        if(jag6Forward){
            jag6.set(0.75);
        }else{
            jag6.set(0.0);
        }
        
        if(jag7Forward){
            jag7.set(0.75);
        }else{
            jag7.set(0.0);
        }
        
        if(victor1Forward){
            victor1.set(0.75);
        }else{
            victor1.set(0.0);
        }
        
        if(victor2Forward){
            victor2.set(0.75);
        }else{
            victor2.set(0.0);
        }
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
