/*
 * This file is part of Quilt Loom, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2016, 2017, 2018 FabricMC, 2021 QuiltMC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.quiltmc.loom.task;

import java.io.IOException;

import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import org.quiltmc.loom.LoomGradleExtension;
import org.quiltmc.loom.configuration.providers.minecraft.MinecraftNativesProvider;
import org.quiltmc.loom.configuration.providers.minecraft.assets.MinecraftAssetsProvider;

public class DownloadAssetsTask extends AbstractLoomTask {
	@TaskAction
	public void downloadAssets() throws IOException {
		Project project = this.getProject();
		LoomGradleExtension extension = getExtension();

		MinecraftAssetsProvider.provide(extension.getMinecraftProvider(), project);
		MinecraftNativesProvider.provide(project);
	}
}