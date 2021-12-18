package frc.team5115;

public class Constants{

    public static final boolean MECANUM = true; 
 
   
    //autonomous stuff
    public static final StartingConfiguration startingConfiguration = StartingConfiguration.Middle;
    public static final double startY = 120;
    public static final int startingAngle = -45; //90 is looking away from the driver stations.

    public static final double AUTO_MAX_THROTTLE = 0.3;
    public static final double AUTO_CAMERA_HEIGHT = 14.5; //units: inches.
    public static final double AUTO_CAMERA_ANGLE = 5; //units: degrees.
    public static final double AUTO_SHOOTIN_DISTANCE = 120; //units: inches. todome update
    public static final double AUTO_HIGH_GOAL_HEIGHT = 90; //units: inches.

    //motor ids
    public static final byte FRONT_LEFT_MOTOR_ID = 1;
    public static final byte FRONT_RIGHT_MOTOR_ID = 2;
    public static final byte BACK_LEFT_MOTOR_ID = 3;
    public static final byte BACK_RIGHT_MOTOR_ID = 4;
    public static final double DEAD_BAND = .02;

    public static final int BUNNY_MOTOR_ID = 5;

    //button ids
    
    public static final byte BUNNY_UP_BUTTON_ID = 1;
    public static final byte BUNNY_DOWN_BUTTON_ID = 2;
    public static final byte TURBO_MODE_BUTTON_ID = 3;

    //X-Box
    public static byte JOY_Y_AXIS_ID = 1;
    public static byte JOY_X_AXIS_ID = 4;
    public static byte JOY_Z_AXIS_ID = 0; 

    public static byte PILOT_X_AXIS_ID= 0;
    public static byte PILOT_Y_AXIS_ID = 1;

    public static float JOY_X_DEADZONE = 0.075f;

    //information on where we start
    public enum StartingConfiguration {
        Right, Middle, Left;
        public double getX() {
            switch (this) {
                case Right:
                    return 50;
                case Middle:
                    return 100;
                case Left:
                    return 200;
            }
            return 0;
        }
    }

    public enum Pipeline {
        DriveCamera, Balls, GreenLedMode;
        public int getPipelineNumber() {
            switch(this) {
                case DriveCamera:
                    return 0;
                case Balls:
                    return 3;
                case GreenLedMode:
                    return 2;
            }
            return -1;
        }
    }
}

