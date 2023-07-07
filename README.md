# Framework2.0
Instructions pour utiliser le framework 
# Configuration 
  - Mettre dans le lib de votre projet le framework.jar
  - Mettre dans un seul package tous les classes
    > Si vous avez plusieurs classes : Vous devez le mettre dans un seul package
      Ex :
           Test 
                - Emp.java
                - Dept.java
    > Ajouter dans le web.xml le package
    > Dans le web.xml  "etu1922.framework.servlet.FrontServlet" doit etre inclus et mettre dans le init-param votre packages   
      Ex:
          <servlet>
                <servlet-name>NomQueVousVoulez</servlet-name>
                <servlet-class>etu1922.framework.servlet.FrontServlet</servlet-class>
                <init-param>
                    <param-name>packages</param-name>
                    <param-value>VotreNomDePackage</param-value>
                </init-param>
                </servlet>
  - Utiliser servlet-api.jar (jakarta) et JDK 17

# Utilisation dans un projet
  1. Importer les packages dans votre classe :
      ->  etu1922.framework.ModelView 
      ->  etu1922.framework.Annotation
     
  2. Routage : Annoter les fonctions avec @Annotation(url="votrechoix")
    Ex:
         @Annotation(url="findAll")
         public void findAll(){
              System.out.println("findAll");
         }
     
  3. Affichage d'un view
     - Mettre le type de retour du fonction en ModelView  
  
  4. Pour passer les donnees depuis le View
     - utiliser le methode POST
     - Les données vont s'affecter vers l'attribut du class contenant la fonction à executer si la clé et l'attribut ont le même nom sinon rien ne se passe
     - Si le type de l'attribut est un tableau votre input name doit etre se terminer par []
    
  5. Pour passer les valeurs aux parametres du fonction
     -  on peut l'affecter depuis le @Parametre dans etu1922.framework.Parametre
       Ex:
          @Annotation(url="getParam")
          public ModelView getParam(@Parametre(param="param")Integer i){
              ModelView temp = new ModelView();
              temp.addItem("test",i);
              temp.setView("Teste.jsp");
              return temp;
          }
     - 
  6. Upload fichier :
  	- Ajouter un attribut FileUpload dans le class de destination qui veut utiliser le fichier
  	- FileUpload est un class composé des attributs name (nom du fichier) , path (destination) , bytes[] (contenue du fichier) 
  	- Ensuite nous allons affecté le fichier dans cette attribut , dans ce cas il faut que le input file doit entre au meme nom 
	  que l'attribut FileUpload est ca ce fait automatiquement après.
	  
  7. Authentification :
  	Pour filtrer les utilisateurs qui ont accés à un fonction :
  	- Ajouter en tant que init-param du web.xml le nom du session d'authentification par exemple : isConnected
  	- Ajouter aussi en init-param le nom du session du profil d'utilisateur par exemple : profile pour stocker les profiles d'utilisateurs
  	- Pour authentifié un utilisateur:
  		- Dans la classe ModelView on doit ajouter le session addSession("isConnected", true) par exemple
  		- Et pour préciser le profil de l'utilisateur : addSession("profile", "admin")
  	- Pour ajouter de l'authentification a un fonction , il faut mettre une annotation @Auth sur le fonction ou @Auth("nom du profil autorisé")
	
  8. Gestion des sessions :
  	- Pour ajouter des sessions on doit appeler seulement addSession(cle, valeur)
  	- Pour prendre les sessions:
  		- Annoter la fonction appelée avec @Session
  		- on doit ajouter un attribut HashMap<String, Object> session dans la classe qui va l'utiliser.
  		- Ensuite getSession(cle) dans la fonction pour avoir le valeur
		
  9. Éxposition API:
  	Pour obtenir le résultat d'une fonction en JSON:
  		- appeler la fonction isJSON(true) du modèle view et après on ajoute les données à partir du addItem() et c'est fini    

     

    
      
     
  
