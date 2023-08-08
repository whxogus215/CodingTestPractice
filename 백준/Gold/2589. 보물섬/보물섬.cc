#include <bits/stdc++.h>
using namespace std;
int n, m, mx, visited[54][54];
const int dy[] = {-1, 0, 1, 0}; 
const int dx[] = {0, 1, 0, -1}; 
char a[54][54];

void bfs(int y, int x){
	memset(visited, 0, sizeof(visited));
	visited[y][x] = 1;
	queue<pair<int, int>> q;
	q.push({y,x});
	
	while(q.size()){
		tie(y, x) = q.front(); q.pop();
		for(int i = 0; i < 4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if(visited[ny][nx] || a[ny][nx] == 'W') continue;
			
			// 최단거리를 구하는 핵심 로직 
			visited[ny][nx] = visited[y][x] + 1;
			q.push({ny, nx});
			
			// 매 탐색마다 최단거리를 최대값으로 갱신 
			mx = max(mx, visited[ny][nx]);
		}
	}

	return ;
}



int main(){
	
	cin >> n >> m;
	for(int i = 0 ; i < n; i++){
		for(int j = 0; j < m; j++){
			cin >> a[i][j];
		}
	}
	
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			if(a[i][j] == 'L') bfs(i, j);
		}
	}
	
	cout << mx - 1 << "\n"; 

	return 0;
}