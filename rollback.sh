#!/bin/bash

mvn liquibase:rollback "-Dliquibase.rollbackCount=$1"