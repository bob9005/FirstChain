import java.util.Date;

public class Block

{
    //Variables
    public String hash;
    public String previoushash;
    public String data;
    private long timeStamp;//as a number of miliseconds since 1/1/1970 lamp
    private int nonce;

    //Block Construcutre
    public Block(String data, String previoushash)
    {
        this.data = data;

        this.previoushash = previoushash;
        this.timeStamp = new Date().getTime();


        this.hash = calculateHash(); //assigning the hash
    }

    public String calculateHash()
    {

        String calculatedhash = StringUtil.applySha256(previoushash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
        return calculatedhash;
    }

    public void mineBlock(int difficulty)
    {
        String target = new String(new char[difficulty]).replace('\0','0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0,difficulty).equals(target))
        {

            nonce++;
            hash = calculateHash();


        }
        System.out.println("Block Mined!! : " + hash);


    }
}
