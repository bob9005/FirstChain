import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class FirstChainP2
{
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;

    public static boolean isChainValid() {
        Block currentBlock;
        Block prevBlock;


        //loop throuugh blockchain to check hashes
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            prevBlock = blockchain.get(i - 1);

            //compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            if(!prevBlock.hash.equals(prevBlock.calculateHash()))
            {
                System.out.println("Previous Hashes not equal");
                return false;
            }

        }
        return true;
    }
    public static void main(String[] args)
    {
        //add our blocks to the blockchain Array List
        blockchain.add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to mine block  1 ... ");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Hi im the second block", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to mine block 2 ... ");
        blockchain.get(1).mineBlock(difficulty);


        blockchain.add(new Block("Hi im the third block", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to mien block 3 ... ");
        blockchain.get(2).mineBlock(difficulty);


        System.out.println("\nBlockchain is Valid: " + isChainValid());


        System.out.println("\nThe block chain: ");

        String blockJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockJson);


    }
}
