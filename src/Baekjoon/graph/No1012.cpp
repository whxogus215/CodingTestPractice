#include <bits/stdc++.h>
using namespace std;

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
int T, M, N, K, y, x, ny, nx, ret;
int arr[50][50];
int visited[50][50];

void DFS(int y, int x){
	if(visited[y][x]) return;
	
	visited[y][x] = 1;
	
	for(int i = 0; i < 4; i++){
		ny = y + dy[i];
		nx = x + dx[i];
		
		if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
		if(!arr[ny][nx]) continue;
		DFS(ny,nx);
	}
	
	return ;
}

int main(){
	
	cin >> T;
	
	for(int i = 0; i < T; i++){
		cin >> M >> N >> K;
		for(int i = 0; i < K; i++){
			cin >> x >> y;
			arr[y][x] = 1;
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(arr[i][j] && !visited[i][j]) {
					DFS(i, j);
					ret += 1;
				}
			}
		}
		
		cout << ret << "\n";
		ret = 0;
				
        memset(arr, 0, sizeof(arr));
        memset(visited, 0, sizeof(visited));
	}

	return 0;
}
