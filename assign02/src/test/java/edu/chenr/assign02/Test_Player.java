package edu.chenr.assign02;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Player {
    @Test()
    public void test_firstName() {
        Superhero p1 = new Superhero();
        Superhero p2 = new Superhero();
        Assert.assertEquals(p1.getHeroName(), "");
        Assert.assertEquals(p2.getHeroName(), "");

        p1.setHeroName("Bob");
        p2.setHeroName("Joe");
        Assert.assertEquals(p1.getHeroName(), "Bob");
        Assert.assertEquals(p2.getHeroName(), "Joe");
    }

    @Test()
    public void test_lastName() {
        Superhero p1 = new Superhero();
        Superhero p2 = new Superhero();
        Assert.assertEquals(p1.getRealName(), "");
        Assert.assertEquals(p2.getRealName(), "");

        p1.setRealName("Smith");
        p2.setRealName("Johnson");
        Assert.assertEquals(p1.getRealName(), "Smith");
        Assert.assertEquals(p2.getRealName(), "Johnson");
    }

    @Test()
    public void test_height() {
        Superhero p1 = new Superhero();
        Superhero p2 = new Superhero();
        Assert.assertEquals(p1.getHeight(), 0);
        Assert.assertEquals(p2.getHeight(), 0);

        p1.setHeight(107);
        p2.setHeight(97);
        Assert.assertEquals(p1.getHeight(), 107);
        Assert.assertEquals(p2.getHeight(), 97);
    }

    @Test()
    public void test_weight() {
        Superhero p1 = new Superhero();
        Superhero p2 = new Superhero();
        Assert.assertEquals(p1.getWeight(), 0);
        Assert.assertEquals(p2.getWeight(), 0);

        p1.setWeight(210);
        p2.setWeight(108);
        Assert.assertEquals(p1.getWeight(), 210);
        Assert.assertEquals(p2.getWeight(), 108);
    }

    @Test()
    public void test_calculateBMI() {
        Superhero p = new Superhero();
        p.setHeight(72);
        p.setWeight(165.1);
        Assert.assertEquals(p.calculateBMI(), 22);

        p.setHeight(74);
        p.setWeight(210.3);
        Assert.assertEquals(p.calculateBMI(), 26);

        p.setHeight(70);
        p.setWeight(167.9);
        Assert.assertEquals(p.calculateBMI(), 24);  
    }

    @Test()
    public void test_getNameString() {
        Superhero p = new Superhero();
        Assert.assertEquals(p.getNameString(), " ()");

        p.setHeroName("Super Bobman");
        p.setRealName("Bob Smith");
        Assert.assertEquals(p.getNameString(), "Super Bobman (Bob Smith)");
    }

    @Test()
    public void test_getHeightString() {
        Superhero p = new Superhero();
        Assert.assertEquals(p.getHeightString(), "0'-0\"");

        p.setHeight(72);        
        Assert.assertEquals(p.getHeightString(), "6'-0\"");

        p.setHeight(74);        
        Assert.assertEquals(p.getHeightString(), "6'-2\"");

        p.setHeight(70);        
        Assert.assertEquals(p.getHeightString(), "5'-10\"");
    }

    @Test()
    public void test_getWeightString() {
        Superhero p = new Superhero();
        Assert.assertEquals(p.getWeightString(), "0.0 lbs.");

        p.setWeight(167.9);
        Assert.assertEquals(p.getWeightString(), "167.9 lbs.");
    }

    @Test()
    public void test_toString() {
        Superhero p = new Superhero();

        String output = 
            "NAME:  ()" + "\n" +
            "WEIGHT: 0.0 lbs." + "\n" +
            "HEIGHT: 0'-0\"" + "\n" +
            "BMI: 0" + "\n";

        Assert.assertEquals(p.toString(), output);

        p.setHeroName("The Batman");
        p.setRealName("Bruce Wayne");
        p.setHeight(74);
        p.setWeight(210.3);
        output = """
            NAME: The Batman (Bruce Wayne)
            WEIGHT: 210.3 lbs.
            HEIGHT: 6'-2\"
            BMI: 26   
            """;
        Assert.assertEquals(p.toString(), output);
    }   
}
