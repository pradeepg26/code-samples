#!/usr/bin/python

import sys
import collections

class HopcroftKarp(object):
    INF = sys.maxint

    def __init__(self, G):
        self.G = G
        self.G1 = G.keys()
        self.G2 = [val for subl in G.values() for val in subl]
        self.pair = {}
        self.dist = {}
        self.q = collections.deque()
    
    def match(self):
    # function Hopcroft-Karp
    #     for each v in G
    #         Pair_G1[v] = NIL
    #         Pair_G2[v] = NIL
    #     matching = 0
    #     while bfs() == true
    #         for each v in G1
    #             if Pair_G1[v] == NIL
    #                 if dfs(v) == true
    #                     matching = matching + 1
    #     return matching
        for v in self.G1:
            self.pair[v] = None
            self.dist[v] = HopcroftKarp.INF
        for v in self.G2:
            self.pair[v] = None
            self.dist[v] = HopcroftKarp.INF

        matching = 0
        while self.bfs():
            for v in self.G1:
                if not self.pair[v] and self.dfs(v):
                    matching += 1
        return matching

    def dfs(self, v):
    # function dfs (v)
    #     if v != NIL
    #         for each u in Adj[v]
    #             if Dist[ Pair_G2[u] ] == Dist[v] + 1
    #                 if dfs(Pair_G2[u]) == true
    #                     Pair_G2[u] = v
    #                     Pair_G1[v] = u
    #                     return true
    #         Dist[v] = INF
    #         return false
    #     return true
        if v:
            for u in self.G[v]:
                if self.dist[self.pair[u]] == self.dist[v] + 1 and self.dfs(self.pair[u]):
                    self.pair[u] = v
                    self.pair[v] = u
                    return True
            self.dist[v] = HopcroftKarp.INF
            return False
        else:
            return True

    def bfs(self):
    # function bfs ()
    #     for v in G1
    #         if Pair_G1[v] == NIL
    #             Dist[v] = 0
    #             Enqueue(Q,v)
    #         else
    #             Dist[v] = INF
    #     Dist[NIL] = INF
    #     while Empty(Q) == false
    #         v = Dequeue(Q)
    #         if Dist[v] < Dist[NIL] 
    #             for each u in Adj[v]
    #                 if Dist[ Pair_G2[u] ] == INF
    #                     Dist[ Pair_G2[u] ] = Dist[v] + 1
    #                     Enqueue(Q,Pair_G2[u])
    #     return Dist[NIL] != INF
        for v in self.G1:
            if self.pair[v]:
                self.dist[v] = HopcroftKarp.INF
            else:
                self.dist[v] = 0
                self.q.append(v)

        self.dist[None] = HopcroftKarp.INF

        while self.q:
            v = self.q.popleft()
            if v:
                for u in self.G[v]:
                    if self.dist[self.pair[u]] == HopcroftKarp.INF:
                        self.dist[self.pair[u]] = self.dist[v] + 1
                        self.q.append(self.pair[u])
        return self.dist[None] != HopcroftKarp.INF

