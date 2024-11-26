#!/bin/sh

export DB_PASSWORD=$(cat /run/secrets/db-password)

exec "$@"