import java.util.List;
import java.util.Scanner;

import Entities.Client;
import Entities.Adresse;
import Services.ClientServices;
import Services.AdresseServices;

public class View {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        //Dependances
        ClientServices clientService=new ClientServices();
        AdresseServices adresseService=new AdresseServices();
       
        do {
            System.out.println("1-Créer un Client");
            System.out.println("2-Lister les Clients"); 
            System.out.println("3-Ajouter une Adresse et lui associer un Client"); 
            System.out.println("4-Lister les Adresses en affichant le nom du Client");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                     System.out.println("Entrer le Nom Complet");
                     String nomComplet=sc.nextLine(); 
                     System.out.println("Entrer le Téléphone");
                     String telephone=sc.nextLine();  
                     System.out.println("Entrer un mail");
                     String email=sc.nextLine();   
                     Client cli=new Client();
                      cli.setNomComplet(nomComplet);
                      cli.setTelephone(telephone);
                      cli.setEmail(email);
                    clientService.ajouterClient(cli);
                    break;
                
                case 2:
                    List<Client> clients=  clientService.listerClient();
                     for (Client client: clients) {
                          System.out.println("NomComplet "+ client.getNomComplet());
                          System.out.println("Telephone "+ client.getTelephone());
                          System.out.println("Emmail "+ client.getEmail());
                          System.out.println("**********************************");
                     }
                    break;

                    case 3:
                    System.out.println("Entrer la ville : ");
                    String ville = sc.nextLine();
                    System.out.println("Entrer le quartier : ");
                    String quartier = sc.nextLine();
                    System.out.println("Entrer le numéro de la villa : ");
                    String numVilla = sc.nextLine();
                    System.out.println("Entrer le téléphone du client : ");
                    String telClient = sc.nextLine();
                    Client client = clientService.rechercherClientParTel(telClient);
                    if (client != null) {
                        Adresse adresse = new Adresse();
                        adresse.setVille(ville);
                        adresse.setQuartier(quartier);
                        adresse.setNumVilla(numVilla);
                        adresse.setClient(client);
                        adresseService.ajouterAdresse(adresse);
                        System.out.println("Adresse ajoutée avec succès et associée au client.");
                    } else {
                        System.out.println("Client non trouvé. Veuillez d'abord créer le client.");
                    }
                    break;
                

                    case 4:
                    List<Adresse> adresses= adresseService.listerAdresse();
                    for (Adresse adr: adresses) {
                         System.out.println("Ville :"+ adr.getVille());
                         System.out.println("Quartier :"+ adr.getQuartier());
                         System.out.println("NumVilla :"+ adr.getNumVilla());
                         System.out.println("Client :"+ adr.getClient().getNomComplet()+" "+adr.getClient().getTelephone());
                         System.out.println("*********************************");
                    }
                   break;
                default:
                    break;
            }

        } while (choix!=5);
        
    
    }
}
