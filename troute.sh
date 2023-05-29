#!/bin/bash
# route git 4.0

rm -rf .DS_Store/
git add . && \
git add -u && \
git commit -m $'Routine Commit\nby @arfazhxss on '"$(date)" && \
git push origin HEAD
git log > commit-hist.txt
rm -rf .DS_Store/