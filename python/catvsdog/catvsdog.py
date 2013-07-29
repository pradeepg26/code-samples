#!/usr/bin/python
from bipartite_graph import *

def test():
    (c, d, v) = map(int, raw_input().split(' '))
    cat_lovers = []
    dog_loves = {}
    cat_hates = {}
    graph = {}
    for i in range(0, v):
        line = raw_input();
        (upvote, downvote) = line.split(' ')
        vote = (i, upvote, downvote)
        if upvote[0] == 'D':
            if upvote in dog_loves:
                dog_loves[upvote].add(vote)
            else:
                dog_loves[upvote] = set()
                dog_loves[upvote].add(vote)

            if downvote in cat_hates:
                cat_hates[downvote].add(vote)
            else:
                cat_hates[downvote] = set()
                cat_hates[downvote].add(vote)
        else:
            cat_lovers.append(vote)

    for vote in cat_lovers:
        (cat_lover, cat_vote, dog_vote) = vote
        dog_love_conflicts = dog_loves.get(dog_vote, set())
        cat_hate_conflicts = cat_hates.get(cat_vote, set())
        if graph.has_key(vote):
            pre_conflicts = graph[vote]
        else:
            pre_conflicts = set()
        pre_conflicts.update(dog_love_conflicts)
        pre_conflicts.update(cat_hate_conflicts)
        #for vx in dog_love_conflicts:
        #    pre_conflicts.add(vx)
        #for vx in cat_hate_conflicts:
        #    pre_conflicts.add(vx)
        graph[vote] = pre_conflicts
    graph_comp = HopcroftKarp(graph)
    return v - graph_comp.match()

def catvsdog():
    num_testcases = int(raw_input())
    for t in range(0, num_testcases):
        print test()

if __name__ == "__main__":
    catvsdog()
