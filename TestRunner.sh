#!/bin/sh
# ========================================
GITHUB_ACCOUNT=EminShQA
WS_DIR=Workspace
REPO_NAME=Title_Validation_CSV
APP_VERSION=1.1
MAIN_CLASS=core.Title_Validation_CSV
ARGS_01=
# ========================================
# ========================================
# GITHUB_ACCOUNT=$1
# WS_DIR=$2
# REPO_NAME=$3
# APP_VERSION=$4
# MAIN_CLASS=$5
# ARGS_01=$6
# ========================================

if ! which java >/dev/null 2>&1 ; then echo Java not installed; return; fi
if ! which mvn >/dev/null 2>&1 ; then echo Maven not installed; return; fi
if ! which git >/dev/null 2>&1 ; then echo Git not installed; return; fi


#if [ -d “$WS_DIR" ] ; then cd ./$WS_DIR; else mkdir $WS_DIR; cd $WS_DIR; fi

if [ -d "$REPO_NAME" ]; then rm -rf $REPO_NAME; fi

git clone https://github.com/$GITHUB_ACCOUNT/$REPO_NAME.git

cd $REPO_NAME

mvn package
echo "Executing Java programm ..."
#java -jar $HOME/$WS_DIR/$REPO_NAME/target/$REPO_NAME-$APP_VERSION.jar $MAIN_CLASS
#$ARGS_01
java -jar ./target/$REPO_NAME-$APP_VERSION-jar-with-dependencies.jar $MAIN_CLASS $ARGS_01