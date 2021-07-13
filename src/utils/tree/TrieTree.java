package utils.tree;

public class TrieTree {
    private boolean isEnd;
    private TrieTree[] links;

    public TrieTree() {
        this.links=new TrieTree[26];//26个英文小写字母
    }


    public void insert(String word) {
        TrieTree cur = this;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.links[c] == null)//前缀树不存在该字符，添加一个分支
                cur.links[c] = new TrieTree();

                cur = cur.links[c];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieTree node = this;
        for (int i = 0; i < word.length(); i++) {
            int curLetter = word.charAt(i) - 'a';
            if (node.links[curLetter] == null) return false;
            else node = node.links[curLetter];
        }
        return node.isEnd;
    }

    public boolean startWith(String prefix) {
        TrieTree cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (cur.links[c] == null) return false;
            else cur = cur.links[c];
        }
        return true;
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("apple");
        trieTree.insert("appl");
        System.out.println(trieTree.search("appl"));
        System.out.println(trieTree.startWith("g"));
    }
}
