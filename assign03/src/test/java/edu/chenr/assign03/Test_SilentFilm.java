package edu.chenr.assign03;
// NOTE: CHANGE realemj to YOUR SITNETID!!!

import edu.realemj.testing.GeneralTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Test_SilentFilm {
    private String [] generateInputs() {
        String [] allInputs = new String[Test_Narrator.allLines.length];
        int [] allCounts = Test_Narrator.getLineCounts();
        for(int i = 0; i < allInputs.length; i++) {
             String oneInput = Test_Narrator.allChars[i] + "\n";
             oneInput += allCounts[i] + "\n";
             oneInput += Test_Narrator.allLines[i];
            allInputs[i] = oneInput;
        }
        return allInputs;
    }

    private String getCommonPromptOutput() {
        String promptOutput = "Enter boundary character:\n"
                + "Enter number of lines:\n"
                + "Enter lines:\n";
        return promptOutput;
    }

    @Test()
    public void test_askForNarration() {

        String [] allInputs = generateInputs();

        String promptOutput = getCommonPromptOutput();
        GeneralTesting.OutPack correctOutput = new GeneralTesting.OutPack(promptOutput, "");

        for(int i = 0; i < allInputs.length; i++) {

            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Create Scanner
            Scanner input = new Scanner(allInputs[i]);

            // Generate header
            Narrator header = SilentFilm.askForNarration(input);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutput);

            // Compare header content
            Assert.assertEquals(header.toString(), Test_Narrator.allAnswers[i]);
        }

    }

    @Test()
    public void testMain() {

        String [] allInputs = generateInputs();

        String promptOutput = getCommonPromptOutput();
        promptOutput += "Our story begins...\n";

        GeneralTesting.OutPack [] correctOutputs = new GeneralTesting.OutPack[Test_Narrator.allAnswers.length];
        for(int i = 0; i < correctOutputs.length; i++) {
            correctOutputs[i] = new GeneralTesting.OutPack(
                    promptOutput + Test_Narrator.allAnswers[i] + "\n", "");
        }

        for(int i = 0; i < allInputs.length; i++) {

            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            SilentFilm.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutputs[i]);

        }
    }
}
