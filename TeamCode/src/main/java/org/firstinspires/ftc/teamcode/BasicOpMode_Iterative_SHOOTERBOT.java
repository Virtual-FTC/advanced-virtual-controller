package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Basic: Iterative OpMode Shooter Bot", group="TeleOp")
public class BasicOpMode_Iterative_SHOOTERBOT extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor1, motor2, motor3, motor4, motor5, motor6, motor7, motor8;
    double movementPower = 1.0, fL_power, fR_power, bL_power, bR_power;

    /*
     * Code to run ONCE when the driver hits INIT
     */

    @Override
    public void init() {
        motor1 = this.hardwareMap.dcMotor.get("motor1");
        motor2 = this.hardwareMap.dcMotor.get("motor2");
        motor3 = this.hardwareMap.dcMotor.get("motor3");
        motor4 = this.hardwareMap.dcMotor.get("motor4");
        motor5 = this.hardwareMap.dcMotor.get("motor5");
        motor6 = this.hardwareMap.dcMotor.get("motor6");
        motor7 = this.hardwareMap.dcMotor.get("motor7");
        motor8 = this.hardwareMap.dcMotor.get("motor8");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        fL_power = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y) * Math.cos(Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4) - gamepad1.right_stick_x / 2;
        fR_power = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y) * Math.sin(Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4) + gamepad1.right_stick_x / 2;
        bL_power = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y) * Math.sin(Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4) - gamepad1.right_stick_x / 2;
        bR_power = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y) * Math.cos(Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4) + gamepad1.right_stick_x / 2;

        motor1.setPower(-movementPower * fL_power);
        motor2.setPower(-movementPower * fR_power);
        motor3.setPower(-movementPower * bL_power);
        motor4.setPower(-movementPower * bR_power);

        if(gamepad1.a) {
            motor5.setPower(1.0);
        } else if(gamepad1.b) {
            motor6.setPower(1.0);
        } else if(gamepad1.y) {
            motor7.setPower(1.0);
            motor8.setPower(-1.0);
        } else {
            motor5.setPower(0.0);
            motor6.setPower(0.0);
            motor7.setPower(0.0);
            motor8.setPower(0.0);
        }
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}