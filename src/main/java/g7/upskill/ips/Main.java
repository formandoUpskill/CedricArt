package g7.upskill.ips;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        // Original string with multiple single quotes
        String originalString = "The 17th centur'y was marked by increasingly robust global networks of trade, " +
                "which brought a great deal of exchange of artistic objects and the global spread of styles. " +
                "This was facilitated by British and Dutch trading companies in South Asia, the trade routes of the Ottoman Empire, " +
                "and the Spanish administration of South America, amongst many other channels. China, Japan and Korea each experienced dramatic economic" +
                " expansion and artistic flourishing, but while Chinese goods travelled widely through the global market, " +
                "Japan maintained a closed economy. The great variety of artistic production in Europe in the 17th century " +
                "is often loosely grouped under the term “[Baroque](/gene/baroque)”, which in general terms is characterized by a heightened sense" +
                " of movement and lighting in compositions. In painting, these elements were perhaps first mastered by Caravaggio, " +
                "who heavily influenced artists across Europe; amongst these were [Diego Velázquez](/artist/diego-velazquez) " +
                "in Spain and and [Rembrandt](/artist/rembrandt-harmensz-van-rijn-1) in Holland. The exuberance of Baroque aesthetics " +
                "combined with the fervor of the Catholic Counter-Reformation is evident in the re-constructed St. Peter's Basilica in the Vatican, " +
                "a project which was seen to completion by [Gian Lorenzo Bernini](/artist/gian-lorenzo-bernini). The taste for Baroque art " +
                "travelled to the Americas, as evidenced by ornate religious buildings most notably in Mexico and Peru. " +
                "In France, the century witnessed the consolidation of power under absolute monarchy, whose decadence was made visible in " +
                "the construction of Louis XIV's royal palace at Versailles; the French Royal Academy of Painting and Sculpture was also established under" +
                " his rule. In the Dutch Republic, whose independence was gained from Spain after 80 years of conflict, an affluent mercantile " +
                "class created the conditions for a dynamic art market with a preference for portraits, still lifes, cityscapes, and scenes of everyday life";

        // Replace the first single quote with another character or sequence
        String replacedString = originalString.replace("'", "");

        // Display the original and replaced strings
        System.out.println("Original String: " + originalString);
        System.out.println("Replaced String: " + replacedString);



        String dateString="2010-12-20T19:48:55+00:00";

        String YearMonthDay = dateString.substring(0,10);

        LocalDate date = LocalDate.parse(YearMonthDay);

        System.out.println("date: " + date);








    }
}