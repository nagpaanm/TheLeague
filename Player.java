/*
Anmol Nagpal
 */

package content;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Player {

    private String name;
    private String url;
    private String age;
    private String team;
    private String ppg;
    private String apg;
    private String rpg;
    private String PER;
    private String gp;
    private String fgP;
    private String tpP;
    private String ftP;
    private String bpg;
    private String spg;
    private String mpg;
    private String pf;
    private String to;
    private String title;
    private String source = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/";
    
    public Player(String name, String url){
        this.name = name;
        this.url = url;
    }
    
    private void setSource(){
        for(int i = 0; i < this.url.length(); i++){
            if(this.url.charAt(i) == "0".charAt(0) ||
                    this.url.charAt(i) == "1".charAt(0) ||
                    this.url.charAt(i) == "2".charAt(0) ||
                    this.url.charAt(i) == "3".charAt(0) ||
                    this.url.charAt(i) == "4".charAt(0) ||
                    this.url.charAt(i) == "5".charAt(0) ||
                    this.url.charAt(i) == "6".charAt(0) ||
                    this.url.charAt(i) == "7".charAt(0) ||
                    this.url.charAt(i) == "8".charAt(0) ||
                    this.url.charAt(i) == "9".charAt(0)){
                this.source += this.url.charAt(i);
            }
        }
        this.source += ".png";
    }
    
    public String getSource(){
        setSource();
        return this.source;
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }
    
    /**
     * @return the pf
     */
    public String getPf() {
        return pf;
    }

    /**
     * @param pf the pf to set
     */
    public void setPf(String pf) {
        this.pf = pf;
    }
    
    /**
     * @return the mpg
     */
    public String getMpg() {
        return mpg;
    }

    /**
     * @param mpg the mpg to set
     */
    public void setMpg(String mpg) {
        this.mpg = mpg;
    }

    /**
     * @return the gp
     */
    public String getGp() {
        return gp;
    }

    /**
     * @param gp the gp to set
     */
    public void setGp(String gp) {
        this.gp = gp;
    }

    /**
     * @return the fgP
     */
    public String getFgP() {
        return fgP;
    }

    /**
     * @param fgP the fgP to set
     */
    public void setFgP(String fgP) {
        this.fgP = fgP;
    }

    /**
     * @return the tpP
     */
    public String getTpP() {
        return tpP;
    }

    /**
     * @param tpP the tpP to set
     */
    public void setTpP(String tpP) {
        this.tpP = tpP;
    }

    /**
     * @return the ftP
     */
    public String getFtP() {
        return ftP;
    }

    /**
     * @param ftP the ftP to set
     */
    public void setFtP(String ftP) {
        this.ftP = ftP;
    }

    /**
     * @return the bpg
     */
    public String getBpg() {
        return bpg;
    }

    /**
     * @param bpg the bpg to set
     */
    public void setBpg(String bpg) {
        this.bpg = bpg;
    }

    /**
     * @return the spg
     */
    public String getSpg() {
        return spg;
    }

    /**
     * @param spg the spg to set
     */
    public void setSpg(String spg) {
        this.spg = spg;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * @return the ppg
     */
    public String getPpg() {
        return ppg;
    }

    /**
     * @param ppg the ppg to set
     */
    public void setPpg(String ppg) {
        this.ppg = ppg;
    }

    /**
     * @return the apg
     */
    public String getApg() {
        return apg;
    }

    /**
     * @param apg the apg to set
     */
    public void setApg(String apg) {
        this.apg = apg;
    }

    /**
     * @return the rpg
     */
    public String getRpg() {
        return rpg;
    }

    /**
     * @param rpg the rpg to set
     */
    public void setRpg(String rpg) {
        this.rpg = rpg;
    }

    /**
     * @return the PER
     */
    public String getPER() {
        return PER;
    }

    /**
     * @param PER the PER to set
     */
    public void setPER(String PER) {
        this.PER = PER;
    }
    
    public String getUrl(){
        return this.url;
    }
    
    public String getName(){
        return this.name;
    }
}
