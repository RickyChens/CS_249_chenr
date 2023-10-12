package edu.chenr.assign03;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;

public class Test_Narrator {

    public static final String [] allLines = {
            "",

            "\n",

            """
            ...
            """,

            """
            Arrakis, Dune,
            Desert Planet
            """,

            """
            A long time ago in a galaxy
            far, far away
            
            
            
            STAR WARS
            
                        
            It is a period of civil war.
            Rebel spaceships, striking
            from a hidden base, have won
            their first victory against
            the evil Galactic Empire.
            
            During the battle, Rebel
            spies managed to steal secret
            plans to the Empire's
            ultimate weapon, the DEATH
            STAR, an armored space
            station with enough power to
            destroy an entire planet.
            
            Pursued by the Empire's
            sinister agents, Princess
            Leia races home aboard her
            starship, custodian of the
            stolen plans that can save
            her people and restore
            freedom to the galaxy....              
            """,

            """
            Space: the final frontier.
            
            These are the voyages of the starship
            Enterprise.
            Its five-year mission: 
            to explore strange new worlds;
            to seek out new life and new civilizations;
            to boldly go where no man has gone before!
            """
    };

    public static final char [] allChars = {'.', '.', '*', '$', '#', '@'};

    public static final String [] allAnswers = {
            "",

            """
            ..................................................
            .                                                .
            .                                                .
            .                                                .
            .                                                .
            .                                                .
            .                                                .
            ..................................................
            """,

            """
            **************************************************
            *                                                *
            *                      ...                       *
            *                                                *
            *                                                *
            *                                                *
            *                                                *
            **************************************************
            """,

            """
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            $                                                $
            $                 Arrakis, Dune,                 $
            $                 Desert Planet                  $
            $                                                $
            $                                                $
            $                                                $
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            """,

            """
            ##################################################
            #                                                #
            #          A long time ago in a galaxy           #
            #                 far, far away                  #
            #                                                #
            #                                                #
            #                                                #
            ##################################################
            ##################################################
            #                                                #
            #                                                #
            #                   STAR WARS                    #
            #                                                #
            #                                                #
            #                                                #
            ##################################################
            ##################################################
            #                                                #
            #          It is a period of civil war.          #
            #           Rebel spaceships, striking           #
            #          from a hidden base, have won          #
            #          their first victory against           #
            #                                                #
            ##################################################
            ##################################################
            #                                                #
            #           the evil Galactic Empire.            #
            #                                                #
            #            During the battle, Rebel            #
            #         spies managed to steal secret          #
            #                                                #
            ##################################################
            ##################################################
            #                                                #
            #             plans to the Empire's              #
            #           ultimate weapon, the DEATH           #
            #             STAR, an armored space             #
            #          station with enough power to          #
            #                                                #
            ##################################################
            ##################################################
            #                                                #
            #           destroy an entire planet.            #
            #                                                #
            #            Pursued by the Empire's             #
            #           sinister agents, Princess            #
            #                                                #
            ##################################################
            ##################################################
            #                                                #
            #           Leia races home aboard her           #
            #           starship, custodian of the           #
            #           stolen plans that can save           #
            #             her people and restore             #
            #                                                #
            ##################################################
            ##################################################
            #                                                #
            #           freedom to the galaxy....            #
            #                                                #
            #                                                #
            #                                                #
            #                                                #
            ##################################################     
            """,

            """
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @                                                @
            @           Space: the final frontier.           @
            @                                                @
            @     These are the voyages of the starship      @
            @                  Enterprise.                   @
            @                                                @
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            @                                                @
            @             Its five-year mission:             @
            @         to explore strange new worlds;         @
            @  to seek out new life and new civilizations;   @
            @   to boldly go where no man has gone before!   @
            @                                                @
            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            """
    };

    public Narrator[] createSamples() {
        Narrator[] samples = new Narrator[allLines.length];
        samples[0] = new Narrator(new String[]{}, allChars[0]);
        samples[1] = new Narrator(new String[]{""}, allChars[1]);
        for(int i = 2; i < allLines.length; i++) {
            samples[i] = new Narrator(allLines[i].split("\n"), allChars[i]);
        }
        return samples;
    }

    public static int [] getLineCounts() {
        int [] allCounts = new int[allLines.length];
        allCounts[0] = 0;
        allCounts[1] = 1;
        for(int i = 2; i < allLines.length; i++) {
            allCounts[i] = allLines[i].split("\n").length;
        }
        return allCounts;
    }

    @Test()
    public void test_getLines() {
        Narrator[] samples = createSamples();
        for(int i = 0; i < samples.length; i++) {
            Assert.assertEquals(samples[i].getLines(), allLines[i] + "");
        }

        // Verify we aren't just copying the reference
        String fullExampleLine = "We do\n...stuff...\n";
        String [] exampleLine = fullExampleLine.split("\n");

        Narrator example = new Narrator(exampleLine, '$');
        Assert.assertEquals(example.getLines(), fullExampleLine);
        exampleLine[0] = "We really do";
        Assert.assertEquals(example.getLines(), fullExampleLine, "Do NOT just copy references!");
    }

    @Test()
    public void test_getBoundaryChar() {
        Narrator[] samples = createSamples();
        for(int i = 0; i < samples.length; i++) {
            Assert.assertEquals(samples[i].getBoundaryChar(), allChars[i]);
        }
    }

    @Test()
    public void test_setLines() {
        Narrator[] samples = createSamples();
        String newLine = "Do you know\nthe Muffin Man????\n";
        String [] lineArray = newLine.split("\n");
        samples[0].setLines(lineArray);
        Assert.assertEquals(samples[0].getLines(), newLine);

        // Changing the array to make sure a copy was made internally
        lineArray[0] = "Dost thou know";
        Assert.assertEquals(samples[0].getLines(), newLine, "Do NOT just copy references!");
    }

    @Test()
    public void test_setBoundaryChar() {
        Narrator[] samples = createSamples();
        char newChar = '&';
        samples[0].setBoundaryChar(newChar);
        Assert.assertEquals(samples[0].getBoundaryChar(), newChar);
    }

    @Test()
    public void test_generateBoundaryLine() {
        Narrator example = new Narrator(new String[]{""}, '*');
        Assert.assertEquals(
                example.generateBoundaryLine(),
                "**************************************************\n");

        example.setBoundaryChar('$');
        Assert.assertEquals(
                example.generateBoundaryLine(),
                "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
    }

    @Test()
    public void test_generateCenteredLine() {
        Narrator example = new Narrator(new String[]{""}, '*');
        Assert.assertEquals(
                example.generateCenteredLine(""),
                "*                                                *\n");

        Assert.assertEquals(
                example.generateCenteredLine("a"),
                "*                       a                        *\n");

        Assert.assertEquals(
                example.generateCenteredLine("ab"),
                "*                       ab                       *\n");

        Assert.assertEquals(
                example.generateCenteredLine("012345678901234567890123456789012345678901234567"),
                "*012345678901234567890123456789012345678901234567*\n");

        Assert.assertEquals(
                example.generateCenteredLine("01234567890123456789012345678901234567890123456"),
                "*01234567890123456789012345678901234567890123456 *\n");

        example.setBoundaryChar('$');
        Assert.assertEquals(
                example.generateCenteredLine("ab"),
                "$                       ab                       $\n");
    }

    @Test()
    public void test_toString() {
        Narrator[] samples = createSamples();

        // Testing based strictly on constructor
        for(int i = 0; i < samples.length; i++) {
            Assert.assertEquals(samples[i].toString(), allAnswers[i]);
        }

        // Change one of them and try again
        String newLines = "Do you know\nthe Muffin Man????\n";
        samples[0].setLines(newLines.split("\n"));
        char newChar = '&';
        samples[0].setBoundaryChar(newChar);

        Assert.assertEquals(samples[0].toString(),
                """
                        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                        &                                                &
                        &                  Do you know                   &
                        &               the Muffin Man????               &
                        &                                                &
                        &                                                &
                        &                                                &
                        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                        """);
    }
}
