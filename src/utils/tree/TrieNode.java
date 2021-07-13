package utils.tree;

public class TrieNode {
    public boolean isEnd;
    public TrieNode[] links;

    public TrieNode() {
        this.links=new TrieNode[26];//26个英文小写字母
    }

}
//public class TrieNode {
//
//    // R links to node children
//    public TrieNode[] trieNode;
//
//    public final int R = 26;
//
//    public boolean isEnd;
//
//    public TrieNode() {
//        trieNode = new TrieNode[R];
//    }
//
////    public boolean containsKey(char ch) {
////        return links[ch -'a'] != null;
////    }
////    public TrieNode get(char ch) {
////        return links[ch -'a'];
////    }
////    public void put(char ch, TrieNode node) {
////        links[ch -'a'] = node;
////    }
////    public void setEnd() {
////        isEnd = true;
////    }
////    public boolean isEnd() {
////        return isEnd;
////    }
//}

