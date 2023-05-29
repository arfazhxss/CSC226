#!/bin/bash
# route git 4.1

echo "Enter commit message:"
read commit_message

rm -rf .DS_Store/
git add . && \
git add -u && \
git commit -m $"$commit_message\nby @arfazhxss on $(date)" && \
git push origin HEAD
git log > commit-hist.txt
rm -rf .DS_Store/
