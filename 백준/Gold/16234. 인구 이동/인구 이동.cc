#include <bits/stdc++.h>
using namespace std;

int n, L, R, arr[54][54], visited[54][54], cnt, sum;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};

vector<pair<int, int>> v;

void DFS(int y, int x){
	
	visited[y][x] = 1;
	v.push_back({y,x});
	sum += arr[y][x];
	
	for(int i = 0; i < 4; i++){
		int ny = y + dy[i];
		int nx = x + dx[i];
		
		if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx]) continue;
		if(abs(arr[ny][nx] - arr[y][x]) >= L && abs(arr[ny][nx] - arr[y][x]) <= R) DFS(ny,nx);
	}
	
	return ;
}


int main(){
	
	cin >> n >> L >> R;
	
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			cin >> arr[i][j];
		}
	}
	
	while(true){
		bool flag = false;
		memset(visited, 0, sizeof(visited));
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(!visited[i][j]) {
					sum = 0;
					v.clear();
					
					DFS(i,j);
					
					if(v.size() == 1) continue;
					
					for(pair<int, int> _pair : v) {
						arr[_pair.first][_pair.second] = sum / v.size();
						flag = true; // 연합이 있었다는 표시 
					}
				}
			}
		}
		
		if(!flag) break;
		
		cnt++;
	}
	
	
	cout << cnt << "\n";

	return 0;
}