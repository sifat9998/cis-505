public class ProductDB {
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> queue = new GenericQueue<>();

        if (code.equalsIgnoreCase("b")) {
            Ball b1 = new Ball(); b1.setCode("B100"); b1.setDescription("Black Widow 2.0"); b1.setPrice(144.95); b1.setColor("Black and Red"); queue.enqueue(b1);
            Ball b2 = new Ball(); b2.setCode("B200"); b2.setDescription("Axiom Pearl"); b2.setPrice(154.95); b2.setColor("Blue and Red"); queue.enqueue(b2);
            Ball b3 = new Ball(); b3.setCode("B300"); b3.setDescription("Proton Physix"); b3.setPrice(174.95); b3.setColor("Pink and Purple"); queue.enqueue(b3);
            Ball b4 = new Ball(); b4.setCode("B400"); b4.setDescription("Force Unleashed"); b4.setPrice(139.99); b4.setColor("Red and White"); queue.enqueue(b4);
            Ball b5 = new Ball(); b5.setCode("B500"); b5.setDescription("Phaze III"); b5.setPrice(154.99); b5.setColor("Purple and Green"); queue.enqueue(b5);
        } else if (code.equalsIgnoreCase("a")) {
            Bag a1 = new Bag(); a1.setCode("A100"); a1.setDescription("Path Pro Deluxe"); a1.setPrice(34.99); a1.setType("Single"); queue.enqueue(a1);
            Bag a2 = new Bag(); a2.setCode("A200"); a2.setDescription("Prime Roller Black/Royal Blue"); a2.setPrice(54.99); a2.setType("Double"); queue.enqueue(a2);
            Bag a3 = new Bag(); a3.setCode("A300"); a3.setDescription("Silver/Royal Blue"); a3.setPrice(74.99); a3.setType("Triple"); queue.enqueue(a3);
        } else if (code.equalsIgnoreCase("s")) {
            Shoe s1 = new Shoe(); s1.setCode("S100"); s1.setDescription("Men's Ram Black"); s1.setPrice(39.99); s1.setSize(10.5); queue.enqueue(s1);
            Shoe s2 = new Shoe(); s2.setCode("S200"); s2.setDescription("Women's Rise Black/Hot Pink"); s2.setPrice(39.99); s2.setSize(7.0); queue.enqueue(s2);
            Shoe s3 = new Shoe(); s3.setCode("S300"); s3.setDescription("Women's Path Lite Seamless Mesh"); s3.setPrice(54.99); s3.setSize(6.0); queue.enqueue(s3);
            Shoe s4 = new Shoe(); s4.setCode("S400"); s4.setDescription("Men's Tribal White"); s4.setPrice(26.99); s4.setSize(8.5); queue.enqueue(s4);
            Shoe s5 = new Shoe(); s5.setCode("S500"); s5.setDescription("Youth Skull Green/Black"); s5.setPrice(39.99); s5.setSize(3.0); queue.enqueue(s5);
        }

        return queue;
    }
}
