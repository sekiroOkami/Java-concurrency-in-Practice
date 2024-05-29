package org.concurrent.chapter4.monitor;

import net.jcip.annotations.Immutable;

// Immutable values can be freely shared and published, so we no longer need to copy the locations when returning them
@Immutable
public record Point(int x, int y) {
}
