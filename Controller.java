/*
Anmol Nagpal (Sheridan)
 */

package content;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Controller {

    public static ArrayList<Player> getPlayers() throws IOException {
        ArrayList<Player> playerList = new ArrayList();
        FileReader fr = new FileReader("links.dat");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, ",");
            String name = st.nextToken();
            String url = st.nextToken();
            Player player = new Player(name, url);
            playerList.add(player);
            line = br.readLine();
        }

        return playerList;
    }

    public static int findPlayer(String name, ArrayList<Player> playerList) {
        int index = -1;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return index;
    }
    
    public static Player findPlayer(String name) throws IOException{
        if(name == null){
            throw new IOException();
        }
        String googleSearchURL = "https://www.google.com/search";
        String searchURL = googleSearchURL + "?q="+name+" espn stats"+"&num=1";
        Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
        Element result = doc.getElementById("main");
        Element missSpell = result.getElementById("scl");
        if(missSpell != null){
            System.out.println(missSpell.text());
            name = missSpell.text().substring(0, missSpell.text().length() - 9);
            return findPlayer(name);  //recalling function with proper name
            
        }
        String longURL = result.getElementsByTag("a").get(13).attr("href");

        //System.out.println(result.getAllElements());
        //System.out.println(playerName);
        
        String url = "";
        int i = 0;
        boolean begin = false;
        while(longURL.charAt(i) != "&".charAt(0)){
            if(begin){
                 url += longURL.charAt(i);
            }
            if(longURL.charAt(i) == "=".charAt(0)){
                begin = true;
            }
            i++;
        }
        System.out.println(url);
        return new Player(name, url);
    }

    public static void setPlayerStats(int index, ArrayList<Player> playerList)
                                        throws IOException{
        Document doc = Jsoup.connect(playerList.get(index).getUrl()).get();
        Elements statLine = doc.getElementsByClass("Table2__shadow-container");
        Elements title = doc.getElementsByClass("StatBlock__Header tc ttu clr-white h9 pv2 ph2 truncate list");
        
        StringTokenizer st = new StringTokenizer(statLine.text());
        for(int i = 0; i < 12; i++){
            st.nextToken();
        }
        playerList.get(index).setGp(st.nextToken());
        playerList.get(index).setMpg(st.nextToken());
        playerList.get(index).setFgP(st.nextToken());
        playerList.get(index).setTpP(st.nextToken());
        playerList.get(index).setFtP(st.nextToken());
        playerList.get(index).setRpg(st.nextToken());
        playerList.get(index).setApg(st.nextToken());
        playerList.get(index).setBpg(st.nextToken());
        playerList.get(index).setSpg(st.nextToken());
        playerList.get(index).setPf(st.nextToken());
        playerList.get(index).setTo(st.nextToken());
        playerList.get(index).setPpg(st.nextToken());
        playerList.get(index).setTitle(title.text());
    }
    
    public static void setPlayerStats(Player player)
                                        throws IOException, 
            MalformedURLException, IllegalArgumentException, 
            NoSuchElementException{
        Document doc = Jsoup.connect(player.getUrl()).get();
        Elements statLine = doc.getElementsByClass("Table2__shadow-container");
        Elements title = doc.getElementsByClass("StatBlock__Header tc ttu clr-white h9 pv2 ph2 truncate list");
        System.out.println(statLine.text());
        StringTokenizer st = new StringTokenizer(statLine.text());
        for(int i = 0; i < 12; i++){
            st.nextToken();
        }
        player.setGp(st.nextToken());
        player.setMpg(st.nextToken());
        player.setFgP(st.nextToken());
        player.setTpP(st.nextToken());
        player.setFtP(st.nextToken());
        player.setRpg(st.nextToken());
        player.setApg(st.nextToken());
        player.setBpg(st.nextToken());
        player.setSpg(st.nextToken());
        player.setPf(st.nextToken());
        player.setTo(st.nextToken());
        player.setPpg(st.nextToken());
        player.setTitle(title.text());
    }

}
