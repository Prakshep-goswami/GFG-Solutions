class Solution {
    void reverse(string&a){
        int l=0;
        int r=a.length()-1;
        while(l<r){
            swap(a[l],a[r]);
            l++;
            r--;
        }
    }
    bool check(string a,string b,string t){
        
        int c=0;
        int n=a.length();
        int m=b.length();
        if(t.length()<max(n,m)) return 0;
        reverse(a);
        reverse(b);
        reverse(t);
        for(int i=0;i<min(n,m);i++){
            int s=(a[i]-'0')+(b[i]-'0') +c;
            c=s/10;
            s=s%10;
            char nc=s+'0';
            if(t[i]!=nc) return 0;
        }
        int i=min(n,m);
        while(i<n && i<t.length()){
            int s=(a[i]-'0')+c;
            c=s/10;
            s=s%10;
            char nc=s+'0';
            if(t[i]!=nc) return 0;
            i++;
        }
        while(i<m && i<t.length()){
            int s=(b[i]-'0')+c;
            c=s/10;
            s=s%10;
            char nc=s+'0';
            if(t[i]!=nc) return 0;
            i++;
        }
        while(c && i<t.length()){
            int s=c%10;
            c=c/10;
            char nc=s+'0';
            if(t[i]!=nc) return 0;
            i++;
        }
        
        return c==0 && i>=t.length();
        
        
        
        
    }
    
    bool solve(int i,int c,string a,string b,string&s){
        int n=s.length();
        if(i>=n ) return c==-1;
        
        
        string temp="";
        for(int j=i;j<n;j++){
            temp+=s[j];
            if(c==2){
                if(solve(j+1,c-1,temp,b,s)) return 1;
            }
            else if(c==1){
                if(solve(j+1,c-1,a,temp,s)) return 1;
            }
            else{
                if(check(a,b,temp)){
                    //cout<<a<<" "<<b<<" "<<temp<<endl;
                    if(solve(j+1,-1,b,temp,s)) return 1;
                }
            }
        }
        return 0;
            
    
    }
  public:
    bool isSumString(string &s) {
        // code here
        bool ans=solve(0,2,"","",s);
        return ans;
        
    }
};