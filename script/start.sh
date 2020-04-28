#!/bin/bash

branch=$(git symbolic-ref --short HEAD)
if [[ ${branch} != "feature/"* ]]; then
  echo 'ブランチ名は"feature"から始めてること'
  exit 1
fi

git commit --allow-empty -m "${branch#feature/}の実施"
git log --oneline -n1
