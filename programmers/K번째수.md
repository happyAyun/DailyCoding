# K번째수

- 또 하나의 벡터를 만들어 array를 복사한 후,
- 각 인덱스를 통해 구하였다.
- 벡터 복사는 `vector<int> v (array.begin() + (commands[i][0] - 1), array.begin() + commands[i][1])` 와 같이 진행하였고,
- 풀이를 보니, `vector<int> v = array` 와 같은 코드로 벡터 복사가 된다는 것을 알게 되었다.



```c++
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    for(int i=0;i<commands.size();i++){
        vector<int> v (array.begin() + (commands[i][0] - 1), array.begin() + commands[i][1]);
        sort(v.begin(),v.end());
        answer.push_back(v[commands[i][2] - 1]);
    }
    return answer;
}
```

