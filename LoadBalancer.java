package grace.shuati;
import java.util.*;

public class LoadBalancer {
    List<Integer> idList;
    Map<Integer, Integer> dict;
    public LoadBalancer() {
        idList = new ArrayList<>();
        dict = new HashMap<>();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        int index = idList.size();
        dict.put(server_id, index);
        idList.add(server_id);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    // 用IDLIST最后一个数来补上要被删掉的数
    public void remove(int server_id) {
        int index = dict.get(server_id);
        int lastNum = idList.get(idList.size() - 1);
        dict.put(lastNum, index);
        idList.set(dict.get(server_id), lastNum);
        idList.remove(idList.size() - 1);
        dict.remove(server_id);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        Random rand = new Random();
        int n = rand.nextInt(idList.size());
        return idList.get(n);
    }
}
