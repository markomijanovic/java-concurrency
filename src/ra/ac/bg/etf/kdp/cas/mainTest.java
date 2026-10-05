package ra.ac.bg.etf.kdp.cas;

public class mainTest {
	
	public static void main(String args[]) {
		BoundedBuffer<Integer> buffer=new BoundedBuffer<Integer>();
		
		Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("[PRODUCENT] Pokušavam da ubacim: " + i);
                    
                    buffer.put(i); // Ubacuje broj u bafer
                    
                    System.out.println("[PRODUCENT] Uspešno ubačen: " + i);
                    
                    // Spavamo malo da simuliramo "proizvodnju" nečega (npr. pola sekunde)
                    Thread.sleep(500); 
                }
            } catch (InterruptedException e) {
                System.out.println("[PRODUCENT] Nit je prekinuta!");
            }
        });
		
		Thread consumer= new Thread(()->{
			try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("[KONZUMENT] Čekam da uzmem podatak...");
                    
                    Integer data = buffer.get(); // Vadi broj iz bafera
                    
                    System.out.println("[KONZUMENT] Uzeo sam: " + data);
                    
                    // Konzument je ovde namerno sporiji (spava 1 sekundu)
                    // Ovo će naterati Producenta da popuni bafer i na kraju zaspi/blokira!
                    Thread.sleep(1000); 
                }
            } catch (InterruptedException e) {
                System.out.println("[KONZUMENT] Nit je prekinuta!");
            }
		});
		
		producer.start();
		consumer.start();
		
		
		try {
			consumer.join();
			producer.join();
			System.out.println("Sve niti su zavrsile rad.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	


}
