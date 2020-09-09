package main.algorithm.tree;

public class TrieTree {
    /**
     * Trie树的根节点
     */
    TrieNode root;

    /**
     * 初始化树结构
     */
    public TrieTree() {
        root = new TrieNode();
        root.val = ' ';
    }

    /**
     * 插入几个单词到Trie树中
     */
    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //如果当前单词不存在，则增加一个子节点
            if (currentNode.next[c -'a'] == null) {
                currentNode.next[c - 'a'] = new TrieNode(c);
            }

            currentNode = currentNode.next[c-'a'];
        }
        currentNode.isEnd = true;
    }

    /**
     * 判断某个单词是否在Trie树之中
     */
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i =0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (currentNode.next[c-'a'] == null) {
                return false;
            }
            currentNode = currentNode.next[c-'a'];
        }

        //在每个单词的末尾都有设置为true
        //如果当前是false，那么代表未存储这个单词
        return currentNode.isEnd;
    }

    /**
     * 判断当前的单词是否为Trie树中某个单词的前缀，注意这里的逻辑与查询是相同的，唯一不同的是匹配完前缀之后返回true
     */
    public boolean startWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (currentNode.next[c-'a'] == null) {
                return false;
            }
            currentNode = currentNode.next[c - 'a'];
        }
        return true;
    }


    class TrieNode {
        /**
         * 当前节点存储的字符
         */
        char val;

        /**
         * 标记节点，用来标记当前的节点是否为要存储节点的最后一个字符
         */
        boolean isEnd;
        /**
         * 存储树的下一个节点，只考虑小写，数组大小为26
         * 还可以用Map，linkeedList来存储子节点
         */
        TrieNode[] next = new TrieNode[26];

        public TrieNode(){
        }
        public TrieNode(char val) {
            this.val = val;
        }

    }
}
