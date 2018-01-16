package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GeneralWordCounter implements TextProcessor {
  private Map<String, Integer> counts;
  private Set<String> stopwords;

  public GeneralWordCounter(Set<String> excludeSet) {
    counts = new HashMap<String, Integer>();
    stopwords = excludeSet;

  }

  public void process(String word) {
  	if (counts.containsKey(word) && !stopwords.contains(word)) {
      counts.put(word, counts.get(word) + 1);
  	} else if (!stopwords.contains(word)){
      counts.put(word, 1);
  	}
  }

  public void report() {
    Set<Map.Entry<String,Integer>> wordSet = counts.entrySet();
    List<Map.Entry<String,Integer>> wordList = new ArrayList<>(wordSet);

    for (int i = 0; i < 5 ; i++) {
      System.out.print(wordList.get(i).getKey() + ": " + wordList.get(i).getValue() + ", ");
    }
    System.out.print('\n');




    // for (String word : counts.keySet()) {
    //   if (counts.get(word) > 200) {
    //     System.out.print(word + ": " + counts.get(word) + ", ");
    //   }
    // }
    // System.out.print('\n');
  }
}
