#include <bits/stdc++.h>
using namespace std;

int n, m, a, b, ny, nx;
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int arr[101][101];
int visited[101][101];

queue<pair<int, int>> q;
string s;

void bfs(int y, int x){
	visited[y][x] = 1;
	q.push({y,x});
	
	while(q.size()){
		
		tie(y,x) = q.front(); q.pop();
		for(int i = 0; i < 4; i++){
			ny = y + dy[i];
			nx = x + dx[i];
			if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if(arr[ny][nx] == 0 || visited[ny][nx]) continue;
			
			q.push({ny,nx});
			visited[ny][nx] = visited[y][x] + 1;
		}
	}
}

int main(){
	
	cin >> n >> m;
	for(int i = 0; i < n; i++){
		cin >> s;
		for(int j = 0; j < m; j++){
			arr[i][j] = s[j] - '0';
		}
	}
	
	bfs(0,0);
	
	cout << visited[n-1][m-1];
	
	return 0;
}
