#include <iostream>
#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

char toLower(char ch){
    if(ch>=97 && ch<122)return ch;
    return ch+32;
}

vector<vector<string>> wordCountEngine( const string& document ) 
{


    map<string,pair<int,int>> mp;
    vector<vector<string>>ans;

    int n = document.length();
    int i =0;

    while(i<n){
        int firstOccurence = i;
        string temp ="";

        while( i<n && s[i]!=' '){
            if((document[i]>=97 && document[i]<=122) || (document[i]>=65 && document[i]<=90)){
                 char ch = toLower(document[i]);
                 temp+=ch;
            }
           
            i++;
        }

        // temp=perfect
        if(mp.find(temp)!=mp.end()){
            mp[temp].first++;
        }
        else{ 
            mp[temp].first=1;
            mp[temp].second = firstOccurence;
             }
             i++;

    }

    priority_queue<pair<int,pair<int,string>>>pq;

    for(auto& x : mp){
        string word = x.first;
        int count   = x.second.first;
        int idx    = x.second.second;

        pq.push({count,{idx,word}});
    }

    while(!pq.empty()){
         string word = x.second.second;
        int count   = x.second.first;
        int idx    = x.second.first;

        pq.pop();

        ans.push_back({word,to_string(count)});

    }

    return ans;

}

int main() {

    string s = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
   vector<vector<string>> val = wordCountEngine(s);
   cout<<val;
    

  return 0;
}