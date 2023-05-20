#!/bin/bash
# route git 3.9

rm -rf .DS_Store/
git add . && \
git add -u && \
git commit -m $'Routine Commit\nby @arfazhxss on '"$(date)" && \
git push origin HEAD
rm -rf .DS_Store/