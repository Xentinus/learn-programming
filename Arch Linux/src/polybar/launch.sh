#!/usr/bin/env bash

# Terminate already running bar instances
killall -q polybar

# Wait until the processes have been shut down
while pgrep -u $UID -x polybar > /dev/null; do sleep 8; done

# Launch bars
polybar dvi -r &
polybar hdmi -r &

echo "Polybar launched..."
