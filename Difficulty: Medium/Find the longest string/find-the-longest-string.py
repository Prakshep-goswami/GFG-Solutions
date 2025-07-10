class TrieNode:
    def __init__(self):
        self.children=[None]*26
        self.isEnd=False
        
class Trie:
    def __init__(self):
        self.head=TrieNode()
        
    def insert(self,word):
        curr=self.head
        for char in word:
            idx=ord(char)-ord("a")
            if curr.children[idx] is None:
                curr.children[idx]=TrieNode()
            curr=curr.children[idx]
        curr.isEnd=True
            
    def all_prefix_exists(self,word):
        curr=self.head
        for char in word:
            idx=ord(char)-ord("a")
            if curr.children[idx] is None :
                return False
            curr=curr.children[idx]
            if curr.isEnd==False:
                return False
        return True

class Solution():
    def longestString(self, words):
        t=Trie()
        for word in words:
            t.insert(word)
        ans=""
        for word in words:
            if t.all_prefix_exists(word) and ( len(ans)<len(word) or (len(ans)==len(word) and ans>word) ):
                ans=word
        return ans