package org.firstinspires.ftc.teamcode.teamcode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.teamcode.testsN.DriveTrainIMU;

@Autonomous
public class AutoDireita extends LinearOpMode {

    private DriveTrainIMU drive;
    private static final double tempoTile = 1.5;

    @Override
    public void runOpMode() {
        drive = new DriveTrainIMU(hardwareMap);

        waitForStart();

        if (opModeIsActive()) {
            drive.resetIMU();
            double tempoInicio = getRuntime();

            while (opModeIsActive() && (getRuntime() - tempoInicio < tempoTile)) {
                drive.strafe(0.5);

                if (Math.abs(drive.getRotation()) > 5.0) {
                    break;
                }

                telemetry.addData("quanto o IMU girou", drive.getRotation());
                telemetry.update();
            }

            drive.stop();
        }
    }
}
