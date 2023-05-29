#!/bin/bash

echo "Enter commit message:"
read commit_message

git add . && \
git add -u && \
git commit -m $"$commit_message"$'\nby @arfazhxss on '"$(date)" && \
git push origin HEAD
