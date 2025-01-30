import Western.Cowboy;
import Western.Human;
import Western.Lady;
import Western.Ruffian;
import Western.Story;

public class App {
    public static void main(String[] args) throws Exception {
        // tests in 2-1
        Human h1 = new Human("Bob");
        h1.selfIntroduction();
        h1.drink();    
     
        System.out.println("\n\n");
        // test in 2-2
        Story.narrate("bla-bla");

        System.out.println("\n\n");
        // test du 5 - lady, cowboy, ruffian
        Lady l1 = new Lady("femme", "red");
        System.out.println(l1);
        Lady l2 = new Lady("femme", "red");
        System.out.println(l2);
        Lady l3 = new Lady("femme3", "blue");
        System.out.println(l3);


        Cowboy c1 = new Cowboy("cowboy");
        System.out.println(c1);
        Cowboy c2 = new Cowboy("cowboy");
        System.out.println(c2);
        Cowboy c3 = new Cowboy("cowboy3");
        System.out.println(c3);

        Ruffian r1 = new Ruffian("ruffian");
        System.out.println(r1);
        Ruffian r2 = new Ruffian("ruffian");
        System.out.println(r2);
        Ruffian r3 = new Ruffian("ruffian3");
        System.out.println(r3);


        System.out.println("LADIES");
        System.out.println("equals : " + l1.equals(l2));
        System.out.println("getkidnapped : ");
        l3.getKidapped();
        System.out.println(l3);

        System.out.println("get released : ");
        l3.getReleased(c1);
        System.out.println(l3);
        System.out.println(c1);


        System.out.println("change dress to yellow");
        System.out.println(l3);
        l3.changeDress("yellow");
        System.out.println(l3);

        System.out.println("self introduction");
        l3.selfIntroduction();

        System.out.println("\n\n");

        System.out.println("RUFFIANS");
        System.out.println(r3);
        System.out.println(l3);
        System.out.println("kidnap");
        r3.kidnap(l3);
        System.out.println(r3);
        System.out.println(l3);

        System.out.println("getCaught");
        r3.getCaught(c3);
        System.out.println(r3);




        System.out.println("\n\n");

        System.out.println("COWBOYS");
        System.out.println("shoot");
        System.out.println(c1);
        System.out.println(r3);
        c1.shoot(r3);
        System.out.println(c1);
        System.out.println(r3);







        System.out.println("\n\n");
        // test du 6 - barman



        System.out.println("\n\n");
        // tests final
    }
}
