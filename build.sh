#!/usr/bin/env bash
mvn clean test cobertura:cobertura cobertura:check checkstyle:checkstyle checkstyle:check
